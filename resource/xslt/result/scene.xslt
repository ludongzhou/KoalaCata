<?xml version="1.0" encoding="UTF-8"?><xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <MetaData>
                <Scene>
                    <Title>
                        <SceneTitle>
                            <xsl:value-of select="MetaData.Scene.Title.SceneTitle"/>
                        </SceneTitle>
                    </Title>
                    <Subject>
                            <SubjectTerm>
                                <xsl:value-of select="MetaData.Scene.Subject.SubjectTerm"/>
                            </SubjectTerm>
                            <Keyword>
                                <xsl:value-of select="MetaData.Scene.Subject.Keyword"/>
                            </Keyword>
                    </Subject>
                    <Description>
                        <DescriptionofContent>
                            <xsl:value-of select="MetaData.Scene.Description.DescriptionofContent"/>
                        </DescriptionofContent>
                        <DateofEvent>
                            <xsl:value-of select="MetaData.Scene.Description.DateofEvent"/>
                        </DateofEvent>
                        <NaturalSound>
                            <xsl:value-of select="MetaData.Scene.Description.NaturalSound"/>
                        </NaturalSound>
                    </Description>

                    <Format>
                        <Duration>
                            <xsl:value-of select="CMS/MetaData/Clip/ClipBaseInfo/Duration"/>
                        </Duration>
                        <StartingPoint>
                            <xsl:value-of select="MetaData.Scene.Format.StartingPoint"/>
                        </StartingPoint>
                        <SubtitleForm>
                            <xsl:value-of select="MetaData.Scene.Format.SubtitleForm"/>
                        </SubtitleForm>
                    </Format>
                    <Relation>
                        <IsPartof>
                            <xsl:value-of select="MetaData.Scene.Relation.IsPartof"/>
                        </IsPartof>
                        <References>
                            <xsl:value-of select="MetaData.Scene.Relation.References"/>
                        </References>
                    </Relation>
                </Scene>
        </MetaData>
    </xsl:template>
</xsl:stylesheet>