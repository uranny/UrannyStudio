import { CommunityPost } from "@/type/community/community";
import { JobPost } from "@/type/job/job";
import { RallyPost } from "@/type/rally/rally";
import { useState } from "react";
import { PostType } from "@/type/postType";
import { View, Text, FlatList, StyleSheet, Platform} from "react-native";
import { CommunityPostView } from "../post/communityPostVIew";
import { PostView } from "../post/postView";

interface AnnouncementProps {
    title : string,
    rallyLst ?: RallyPost[]
    jobLst ?: JobPost[]
    communityLst ?: CommunityPost[]
}

export const isRallyPost = (item : PostType) : item is RallyPost=> {
    return "startTime" in item
}

export const isCommunityPost = (item : PostType) : item is CommunityPost => {
    return "comment" in item
}

export const Announcement = (props : AnnouncementProps) => {
    const [loading, setLoading] = useState(true)
    const getData = () => [props.rallyLst, props.jobLst, props.communityLst].find(lst => lst?.length) ?? [];
    const baseLst = getData()
    return (
        <>
            <View style={styles.titleContainer}>
                <Text style={styles.title}>{props.title}</Text>
                <Text style={styles.moreTxt}>더보기</Text>
            </View>
            <FlatList<PostType>
            style = {{paddingStart : 16, paddingEnd : 16, marginTop : 16, marginBottom : 16}}
            horizontal = {isCommunityPost(baseLst[0]) ? false : true}
            scrollEnabled={isCommunityPost(baseLst[0]) ? false : true}
            data={baseLst}
            showsHorizontalScrollIndicator={false}
            showsVerticalScrollIndicator={false}
            contentContainerStyle={
                {
                    gap:isCommunityPost(baseLst[0]) ? 8 : 
                    Platform.select({ios : 16, android : 0})
                }
            }
            onEndReached={() => {
                if(loading){return}
                console.log("로딩 true됨")
                setLoading(true)
                setTimeout(()=>{
                    console.log("로딩 false됨")
                    setLoading(false)
                }, 10000)
            }}
            renderItem={({item}) => (
                isCommunityPost(item) ? 
                <CommunityPostView post={item}/> : 
                isRallyPost(item) ? 
                <PostView rallyPost={item} announcement={true}/> :
                <PostView jobPost={item} announcement={true}/>
            )}/>
        </>
    );
}

const styles = StyleSheet.create({
    titleContainer : {
        marginStart : 20,
        marginEnd : 20,
        marginTop : 24,
        flexDirection: 'row',
        justifyContent : "space-between",
        alignItems : "flex-end"
    },
    title : {
        fontSize : 16,
        fontWeight : 'bold'
    },
    moreTxt : {
        fontSize : 12,
        fontWeight : 'normal',
        color : '#7F7F7F'
    }
})